package com.example.questtugasuserinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


@Composable
fun BiodataScreen() {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var android by remember { mutableStateOf(false) }
    var uiux by remember { mutableStateOf(false) }
    var web by remember { mutableStateOf(false) }

    var namaLengkap by remember { mutableStateOf("") }
    var emailHasil by remember { mutableStateOf("") }
    var tglLahirHasil by remember { mutableStateOf("") }
    var experienceHasil by remember { mutableStateOf("") }
    var skillHasil by remember { mutableStateOf("") }

    val isFormValid =
        firstName.isNotEmpty() &&
                lastName.isNotEmpty() &&
                email.isNotEmpty() &&
                tglLahir.isNotEmpty() &&
                experience.isNotEmpty()

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
                    .fillMaxWidth()
                    .height(
                        dimensionResource(
                            id = R.dimen.header_height
                        )
                    )
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 180.dp, start = 16.dp, end = 16.dp),

                shape = RoundedCornerShape(
                    dimensionResource(
                        id = R.dimen.card_radius
                    )
                )
            ) {

                Column(
                    modifier = Modifier
                        .padding(
                            dimensionResource(id = R.dimen.padding_large)
                        )
                        .verticalScroll(
                            rememberScrollState()
                        )
                ) {

                    Text(
                        text = stringResource(
                            id = R.string.title_form
                        ),
                        style = MaterialTheme.typography.headlineSmall,
                        color = colorResource(
                            id = R.color.purple_primary
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = stringResource(
                            id = R.string.subtitle_form
                        ),
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Row {

                        OutlinedTextField(
                            modifier = Modifier.weight(1f),
                            value = firstName,
                            onValueChange = {
                                firstName = it
                            },
                            label = {
                                Text(
                                    stringResource(
                                        id = R.string.first_name
                                    )
                                )
                            }
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        OutlinedTextField(
                            modifier = Modifier.weight(1f),
                            value = lastName,
                            onValueChange = {
                                lastName = it
                            },
                            label = {
                                Text(
                                    stringResource(
                                        id = R.string.last_name
                                    )
                                )
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = email,
                        onValueChange = {
                            email = it
                        },
                        label = {
                            Text(
                                stringResource(
                                    id = R.string.email
                                )
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row {

                        OutlinedTextField(
                            modifier = Modifier.weight(1f),
                            value = tglLahir,
                            onValueChange = {
                                tglLahir = it
                            },
                            label = {
                                Text(
                                    stringResource(
                                        id = R.string.birth_date
                                    )
                                )
                            }
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        OutlinedTextField(
                            modifier = Modifier.weight(1f),
                            value = experience,
                            onValueChange = {
                                experience = it
                            },
                            label = {
                                Text(
                                    stringResource(
                                        id = R.string.experience
                                    )
                                )
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = stringResource(
                            id = R.string.skill_title
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        horizontalArrangement =
                            Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        SkillCheckBox(
                            text = stringResource(R.string.android),
                            checked = android
                        ) {
                            android = it
                        }

                        SkillCheckBox(
                            text = stringResource(R.string.uiux),
                            checked = uiux
                        ) {
                            uiux = it
                        }

                        SkillCheckBox(
                            text = stringResource(R.string.web),
                            checked = web
                        ) {
                            web = it
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        enabled = isFormValid,
                        onClick = {

                            namaLengkap = "$firstName $lastName"
                            emailHasil = email
                            tglLahirHasil = tglLahir
                            experienceHasil = experience

                            skillHasil = buildString {
                                if (android) append("Android ")
                                if (uiux) append("UI/UX ")
                                if (web) append("Web ")
                            }
                        }
                    ) {
                        Text(
                            text = stringResource(R.string.proceed)
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    if (namaLengkap.isNotBlank()) {

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        ) {

                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {

                                Text(
                                    text = "Nama : $namaLengkap"
                                )

                                Spacer(
                                    modifier = Modifier.height(4.dp)
                                )

                                Text(
                                    text = "Email : $emailHasil"
                                )

                                Spacer(
                                    modifier = Modifier.height(4.dp)
                                )

                                Text(
                                    text = "Tanggal Lahir : $tglLahirHasil"
                                )

                                Spacer(
                                    modifier = Modifier.height(4.dp)
                                )

                                Text(
                                    text = "Experience : $experienceHasil"
                                )

                                Spacer(
                                    modifier = Modifier.height(4.dp)
                                )

                                Text(
                                    text = "Skill : $skillHasil"
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun SkillCheckBox(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )

        Text(text = text)
    }
}