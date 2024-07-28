package com.example.ageverification

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun second(name:String,age:String,nevigationToFirstSCreen:()->Unit){


    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text("RESULT", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Spacer(modifier =Modifier.height(20.dp))
        Text( "Welcome Mr.${name}")
        if(age.toInt()>18 && age.toInt()<60 ){
            Text("Congratulations!!")
            Spacer(modifier = Modifier.height(5.dp))
            Text("You are Eligible for Driving Test")
        }
        else if(age.toInt()<18){
            Text("Sorry!!")
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "You are not Eligible")
        }
        else if(age.toInt()>85){
            Text(text = "You are not Eligible")
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Text Rest GrandPa!!")
        }
        else{
            Text("Congratulations!!")
            Spacer(modifier = Modifier.height(5.dp))
            Text("You are Eligible for Driving Test")
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "You have to submit Medical Report ")
        }


        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { nevigationToFirstSCreen() }) {
            Text(text = "Cheak Another")
        }

    }

}
