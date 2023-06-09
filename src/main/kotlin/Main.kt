import WallService.posts

data class Post(
    val id: Int, // Идентификатор записи
    val ownerId: Int, //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int, //Идентификатор автора записи
    val data: Int, //Время публикации записи в формате unixtime
    val text: String, //текст записи
    val canPin: Boolean, //Информация, может ли текущий пользователь закрепить запись
    val canDelete: Boolean, //Информация, может ли текущий пользователь удалить запись
    val canEdit: Boolean, //Информация, может ли текущий пользователь редактировать запись
    val isFavorite: Boolean, //Добавлен ли объект в закладки у текущего пользователя
    val likes: Likes
)

object Likes {
    val count: Int = 0  // число пользователей которым понравилась запись
    val userLikes: Boolean = false // наличие метки "Мне нравится" от текущего пользователя
    val canLike: Boolean = true // информация, может ли текущий пользователь поставить отметку «Мне нравится»
    val canPublish: Boolean = true // информация, может ли текущий пользователь сделать репост записи

    override fun toString(): String {

        return "Лайки от пользователей: $count"
    }
}


object WallService {

    private var postId: Int = 0
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {

        val postUniqueId = postId + 1
        posts += post
        postId++
        return posts[postUniqueId - 1]
    }

    fun update(newpost: Post): Boolean {
        val checkedId = newpost.id
        for ((index, post) in posts.withIndex()) {
            if (checkedId == post.id) {
                posts[index] = newpost.copy(99, 99, 99, 99999, "new post", false, false, false, false, Likes)
                return true
            }
        }

        return false
    }

    fun clear() {
        posts = emptyArray()
        postId = 0
    }

    fun print() {
        println(posts.joinToString())
    }

    operator fun set(index: Int, value: Post) {
        posts[index] = value
    }
}

fun main() {

    val like1 = Likes

    val post1 = Post(1, 31, 50, 1685030715, "Привет, Мир1!", true, true, false, false, like1)
    val post2 = Post(2, 32, 60, 1685030716, "Привет, Мир2!", true, true, false, false, like1)
    val post3 = Post(3, 33, 70, 1685030717, "Привет, Мир3!", true, true, false, false, like1)
    val post4 = Post(4, 34, 80, 1685030717, "Привет, Мир4!", true, true, false, false, like1)

    val postTest = Post(1, 34, 80, 1685030717, "Привет, Мир4!", true, true, false, false, like1)

    WallService.add(post1)
    WallService.add(post2)
    WallService.add(post3)
    WallService.add(post4)

    WallService.print()
    println("#############")
    println(WallService.update(postTest))
    WallService.print()


}