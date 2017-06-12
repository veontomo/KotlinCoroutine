import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    println("current thread: ${Thread.currentThread().name}")
    println("Start")
    val result = generateString("greeting")
    println("result: $result")
    println("Do something...")
    Thread.sleep(5000)
    println("End")
}

fun generateString(item: String): String? {
    println("1. thread of generateString: ${Thread.currentThread().name}")
    var res: String? = null
    launch(CommonPool) {
        println("(inside launch) thread generateString: ${Thread.currentThread().name}")
        val result = timeConsumingJob()
        res = anotherJob(result)
    }
    println("2. thread of generateString : ${Thread.currentThread().name}")
    return res
}

fun anotherJob(post: String): String {
    println("thread of anotherJob: ${Thread.currentThread().name}")
    Thread.sleep(100)
    val result = post.toUpperCase()
    println("result of anotherJob is ready: $result")
    return result
}


suspend fun timeConsumingJob(): String {
    println("thread timeConsumingJob: ${Thread.currentThread().name}")
    println("Start timeConsumingJob")
    Thread.sleep(800)
    println("result of timeConsumingJob is ready")
    return "abcdef - sought string"
}
