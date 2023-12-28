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


resource "azurerm_virtual_machine" "vms_deployment" {
  name                  = var.vms
  location              = var.region
  resource_group_name   = azurerm_resource_group.rg_depl.name
  vm_size               = var.vm_size
  network_interface_ids = [azurerm_network_interface.main.id]
  delete_os_disk_on_termination = true
  delete_data_disks_on_termination = true
  depends_on = [ azurerm_network_interface_security_group_association.link-sg ]
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
     ssh_keys {
      path     = "/home/azureuser/.ssh/authorized_keys"
      key_data = file("azure_key")
    }
  }
  tags = {
    environment = "staging"
  }
}

output "password" {
  value = random_string.vms_pwd.result
}

output "publicIP" {
  value = data.azurerm_public_ip.vm_pub_ip.ip_address
}
