import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    println("Start")
    val result = postItem("greeting")
    println("Do something 1")
    Thread.sleep(5000)
    println("result: $result")
    println("End")
}

fun postItem(item: String): String? {
    var res: String? = null
    launch(CommonPool) {
        val token = preparePost()
        val post = submitPost(token, item)
        res = processPost(post)

    }
    return res
}

fun processPost(post: String): String {
    return "processing the post: $post"
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
