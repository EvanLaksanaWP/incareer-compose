package com.raion.incareer.data.dummy

import com.raion.incareer.R

data class Company (
    val name: String,
    val logo: Int,
)

val companies = arrayOf(
    Company("PT Telkom Indonesia Tbk", R.drawable.telkom_logo),
    Company("PT Astra International Tbk", R.drawable.astra_logo),
    Company("PT Sinar Mas", R.drawable.sinarmas_logo),
    Company("PT Indofood Tbk", R.drawable.indofood_logo),
    Company("PT Matahari Tbk", R.drawable.matahari_logo),
    Company("PT Bank Mandiri Tbk", R.drawable.mandiri_logo),
    Company("PT Unilever Indonesia Tbk", R.drawable.unilever_logo),
    Company("PT Shopee Indonesia", R.drawable.shopee_logo),
    Company("PT UNIQLO Indonesia", R.drawable.uniqlo_logo),
    Company("PT Gojek Indonesia", R.drawable.gojek_logo)
)