resource "azurerm_network_security_group" "sg-depl" {
  resource_group_name = azurerm_resource_group.rg_depl.name
  location            = azurerm_resource_group.rg_depl.location
  depends_on = [ time_sleep.await_nic,azurerm_network_interface.main ]
  name                = "vm0-sg"
}

resource "azurerm_network_security_rule" "ssh_rule" {
  name                        = "sshInboud"
  priority                    = 300
  direction                   = "Inbound"
  access                      = "Allow"
  protocol                    = "Tcp"
  source_port_range           = "*"
  destination_port_range      = "22"
  source_address_prefix       = "*"
  destination_address_prefix  = "*"
  resource_group_name         = azurerm_resource_group.rg_depl.name
  network_security_group_name = azurerm_network_security_group.sg-depl.name
}

resource "azurerm_network_interface_security_group_association" "link-sg" {
  network_interface_id      = azurerm_network_interface.main.id
  network_security_group_id = azurerm_network_security_group.sg-depl.id
}
