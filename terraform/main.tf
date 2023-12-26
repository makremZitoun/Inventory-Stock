# variable "data" {
#   type = string
#   default = "Testing Terraform"
# } 

# output "name" {
#   value = var.data
# }
terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "3.84.0"
    }
  }

  backend "azurerm" {
    resource_group_name  = "rg-tfstate"
    storage_account_name = "tfstate1612"
    container_name       = "state-container"
    key                  = "terraform.tfstate"
    use_oidc             = true
  }
}

provider "azurerm" {
  features {}
}

resource "random_string" "vms_pwd" {
  length  = 16
  special = true
}

resource "azurerm_resource_group" "rg_depl" {
  name     = "Test_RG"
  location = var.region
}

resource "azurerm_virtual_network" "main" {
  name                = "${var.vms}-network"
  address_space       = ["10.0.0.0/16"]
  location            = azurerm_resource_group.rg_depl.location
  resource_group_name = azurerm_resource_group.rg_depl.name
}

resource "azurerm_subnet" "internal" {
  name                 = "internal"
  resource_group_name  = azurerm_resource_group.rg_depl.name
  virtual_network_name = "${var.vms}-network"
  address_prefixes     = ["10.0.2.0/24"]
  depends_on           = [azurerm_virtual_network.main]
}

resource "azurerm_public_ip" "pubsIps" {
  name                = "${var.vms}-pubip"
  resource_group_name = azurerm_resource_group.rg_depl.name
  location            = azurerm_resource_group.rg_depl.location
  allocation_method   = "Dynamic"
}
resource "azurerm_network_interface" "main" {
  name                = "${var.vms}-nic"
  location            = azurerm_resource_group.rg_depl.location
  resource_group_name = azurerm_resource_group.rg_depl.name
  ip_configuration {
    name                          = "testconfiguration1"
    subnet_id                     = azurerm_subnet.internal.id
    private_ip_address_allocation = "Dynamic"
    public_ip_address_id          = azurerm_public_ip.pubsIps.id
  }
}

resource "azurerm_virtual_machine" "vms_deployment" {
  name                  = var.vms
  location              = var.region
  resource_group_name   = azurerm_resource_group.rg_depl.name
  vm_size               = var.vm_size
  network_interface_ids = [azurerm_network_interface.main.id]
  storage_image_reference {
    publisher = "Canonical"
    offer     = "0001-com-ubuntu-server-jammy"
    sku       = "22_04-lts"
    version   = "latest"
  }
  storage_os_disk {
    name              = "myosdisk1"
    caching           = "ReadWrite"
    create_option     = "FromImage"
    managed_disk_type = "Standard_LRS"
  }
  os_profile {
    computer_name  = "azurehost"
    admin_username = "azureuser"
    admin_password = random_string.vms_pwd.result
  }
  os_profile_linux_config {
    disable_password_authentication = false
  }
  tags = {
    environment = "staging"
  }
}

output "password" {
  value = random_string.vms_pwd.result
}

output "publicIP" {
  value = azurerm_public_ip.pubsIps.ip_address
}
