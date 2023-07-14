package ru.glabrion.composesample

import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostsList(SampleData.list)
        }
    }
}

class Post(
    @DrawableRes val avatarRes: Int,
    val name: String,
    val location: String,
    @DrawableRes val photoRes: Int
)

@Composable
fun PostsList(list: List<Post>) {
    LazyColumn {
        items(list) { item ->
            ItemPost(item)
        }
    }
}

@Composable
fun ItemPost(post: Post) {

    Column(modifier = Modifier.padding(all = 8.dp)) {
        Row {
            Image(
                painter = painterResource(id = post.avatarRes),
                contentDescription = "profile avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = post.name)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = post.location, color = MaterialTheme.colorScheme.secondary)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = post.photoRes),
            contentDescription = "image",
            modifier = Modifier.size(400.dp, 200.dp)
        )

    }

}

@Preview(
    showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ContentPreview() {
    PostsList(SampleData.list)
}
