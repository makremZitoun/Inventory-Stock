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
resource "time_sleep" "await_nic" {
  depends_on = [ azurerm_network_interface.main ]
  destroy_duration = "10s"
}