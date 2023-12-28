data "template_file" "cloud-init" {
    template = file("${path.module}/custom_data.tpl")
}

data "azurerm_public_ip" "vm_pub_ip" {
    name = azurerm_public_ip.pubsIps.name
    resource_group_name = azurerm_resource_group.rg_depl.name
    depends_on = [ azurerm_virtual_machine.vms_deployment ]
}