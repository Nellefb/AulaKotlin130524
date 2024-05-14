package Nellefb.com.github.listadecompras.model

//classe de dados : modelo de dados, satisfaz arquitetura
//construtor
data class ItemModel(
    val name: String,
    val onRemove: (ItemModel) -> Unit
)