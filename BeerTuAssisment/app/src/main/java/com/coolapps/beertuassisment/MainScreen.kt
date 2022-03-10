package com.coolapps.beertuassisment

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.coolapps.beertuassisment.model.Beer
import kotlinx.coroutines.launch



@ExperimentalMaterialApi
@Composable
fun BeerCollection(beer: Beer) {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    val intent = Intent(Intent.ACTION_SEND)
   val packageManager = context.getPackageManager()
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .clickable { }
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface(color = MaterialTheme.colors.onPrimary) {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = beer.image_url,

                        builder = {
                            scale(Scale.FILL)
                            placeholder(R.drawable.placeholder)
                            transformations(CircleCropTransformation())

                        }
                    ),
                    contentDescription = beer.description,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = beer.name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = beer.tagline,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(4.dp)
                    )
                    BottomSheetScaffold(
                        scaffoldState = bottomSheetScaffoldState,
                        sheetContent = {
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .background(Color.Magenta)
                            ) {
                                Column(
                                    Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = beer.description,
                                        style = MaterialTheme.typography.caption,
                                        modifier = Modifier
                                            .background(Color.LightGray)
                                            .padding(4.dp)
                                    )
                                }

                            }
                        }, sheetPeekHeight = 0.dp

                    ) {
                        Card(onClick = {
                            coroutineScope.launch {
                                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                    bottomSheetScaffoldState.bottomSheetState.expand()
                                } else {
                                    bottomSheetScaffoldState.bottomSheetState.collapse()
                                }
                            }
                        }) {
                            Text(text = "Detail", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                IconButton(onClick = {
                    intent.type ="text/plain"
                    intent.setPackage("com.whatsapp")
                    intent.putExtra(Intent.EXTRA_TEXT,beer.description)
                    //intent.putExtra(Intent.EXTRA_TEXT,beer.tagline)
                    if (intent.resolveActivity(packageManager) == null){
                        Toast.makeText(context,"please install whatsApp first.",Toast.LENGTH_SHORT).show()
                        return@IconButton
                    }
                    startActivity(context,intent,null)
                }) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "share icon")

                }


/*
                Button(onClick = {

                    intent.type ="text/plain"
                    intent.setPackage("com.whatsapp")
                    intent.putExtra(Intent.EXTRA_TEXT,beer.description)
                    //intent.putExtra(Intent.EXTRA_TEXT,beer.tagline)
                    if (intent.resolveActivity(packageManager) == null){
                        Toast.makeText(context,"please install whatsApp first.",Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    startActivity(context,intent,null)
                }) {
                    Text(text = "Click")
                }


 */


            }
        }
    }

}
