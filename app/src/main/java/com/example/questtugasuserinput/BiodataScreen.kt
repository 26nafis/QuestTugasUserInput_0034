package com.example.questtugasuserinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource

@Composable
fun BiodataScreen(){
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var android by remember { mutableStateOf(false) }
    var uiux by remember { mutableStateOf(false) }
    var web by remember { mutableStateOf(false) }

    Scaffold { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Image(
                painter = painterResource(id = R.drawable.spider_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .height(
                        dimensionResource(
                            id = R.dimen.header_height
                        )
                    )
            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 180.dp, start = 16.dp, end = 16.dp),

                shape = RoundedCornerShape(dimensionResource(
                    id = R.dimen.card_radius
                ))
            ) {
                Column(
                    modifier = Modifier.padding(
                        dimensionResource(
                            id = R.dimen.padding_large
                        )
                    )
                ) { }
            }
        }
    }
}