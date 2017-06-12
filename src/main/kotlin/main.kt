import com.sun.deploy.trace.TraceLevel.UI
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    postItem("start")
    Thread.sleep(1000)
}

fun postItem(item: String) {
    launch(CommonPool) {
        val token = preparePost()
        val post = submitPost(token, item)
        processPost(post)

    }
}

fun processPost(post: String) {
    println("processing the post: $post")
}

fun submitPost(token: String, item: String): String {
    return "submitting the post: token: $token, item: $item"
}


suspend fun preparePost(): String {
    (1..5).forEach { it -> println("iteration in post preparation: $it") }
    return "post is ready"
}
