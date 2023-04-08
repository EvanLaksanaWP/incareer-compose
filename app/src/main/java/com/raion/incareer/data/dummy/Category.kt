package com.raion.incareer.data.dummy

import androidx.annotation.DrawableRes
import com.raion.incareer.R

data class Category(
    @DrawableRes
    val icon: Int,
    val title: String
)

val categories = listOf(
    Category(title = "Semua Pekerjaan", icon = R.drawable.all_kind_icon),
    Category(title = "Desain & Kreatif", icon = R.drawable.design_creative_icon),
    Category(title = "Keuangan & Akutansi", icon = R.drawable.accountant_icon),
    Category(title = "Marketing & Sales", icon = R.drawable.marketing_sales_icon),
    Category(title = "Teknologi Informasi", icon = R.drawable.information_technology_icon),
    Category(title = "Manajemen Produk", icon = R.drawable.product_management_icon),
)

