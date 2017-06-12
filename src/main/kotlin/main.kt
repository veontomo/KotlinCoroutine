import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    println("Start")
    postItem("greeting")
    println("Do something 1")
    Thread.sleep(5000)

    println("End")
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
    println("Start submitting the post")
    Thread.sleep(800)
    return "submitting the post: token: $token, item: $item"
}


suspend fun preparePost(): String {
    println("Start preparing the post")
    Thread.sleep(800)
    return "post is ready"
}
