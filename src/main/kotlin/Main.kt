import WallService.posts

data class Post(
    val id: Int, // Идентификатор записи
    val ownerId: Int, //Идентификатор владельца стены, на которой размещена запись
    val fromId: Int, //Идентификатор автора записи
    val createdBy: Int, // Идентификатор администратора, который опубликовал запись
    val data: Int, //Время публикации записи в формате unixtime
    val text: String, //текст записи
    val replyOwnerId: Int, //Идентификатор владельца записи, в ответ на которую была оставлена текущая
    val replyPostId: Int, //Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Boolean, // Информация, если запись была создана с опцией "Только для друзей"
    val comments: Comments?, // Информация о комментариях к записи
    val copyright: String, //Источник информации
    val likes: Likes, // Информация о лайках к записи
    val reposts: Reposts, //Информация о репостах записи
    val views: Views, // Информация о просмотрах записи
    val postType: String, // Тип записи (post, repost, reply, postpone, suggest)
    val postSource: PostSource, //Информация о способе размещения записи
    val geo: Geo, //Информация о местоположении
    val singerId: Int, // Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем
    val canPin: Boolean, //Информация, может ли текущий пользователь закрепить запись
    val canDelete: Boolean, //Информация, может ли текущий пользователь удалить запись
    val canEdit: Boolean, //Информация, может ли текущий пользователь редактировать запись
    val isPinned: Boolean, //Информоция о том что запись закреплена
    val markedAsAds: Boolean, //Информация о том, содержит ли запись отметку "реклама"
    val isFavorite: Boolean, //Добавлен ли объект в закладки у текущего пользователя
    val postponedId: Int, // Идентификатор отложенной записи
    val attachment: Array<Attachment> = arrayOf(
        PhotoAttachment(Photo(1, 22, 44, 55, "Text")),
        VideoAttachment(Video(2, 44, "Title", "Desc", 88)),
        AudioAttachment(Audio(3, 44, "Artist", "Title", 99)),
        LinkAttachment(Link("URL", "Title", "Caption", "Desc", "Prev")),
        GraffitiAttachment(Graffiti(33, 55, "URL", 55, 65))
    )
)

object Comments {
    val count: Int = 0 //Количество комментариев
    val can_post: Boolean = true // Информация, может ли текущий пользователь комментировать запись
    val groups_can_post: Boolean = true // Информация, могут ли сообщества комментировать запись
    val can_close: Boolean = true // может ли текущий пользователь закрыть комментарии к записям
    val can_open: Boolean = true //может ли текущий пользователь открыть комментарии к записям
}

object Likes {
    val count: Int = 0  // число пользователей которым понравилась запись
    val userLikes: Boolean = false // наличие метки "Мне нравится" от текущего пользователя
    val canLike: Boolean = true // информация, может ли текущий пользователь поставить отметку «Мне нравится»
    val canPublish: Boolean = true // информация, может ли текущий пользователь сделать репост записи

    override fun toString(): String {

        return "Лайки от пользователей: $count"
    }
}

object Reposts {
    val count: Int = 0 // число пользователей, скопировавших запись
    val user_reposted: Boolean = false //наличие репоста от текущего пользователя
}

object Views {
    val count: Int = 0 //число просмотров записи
}

object PostSource {
    val type: String = "vk" // Тип источника (vk, widget, api, rss, sms)
    val platform: String = "android" // Название платформы (android, iphone, wphone)
    val data: String = "comments" // Тип действия (profile_activity, profile_photo, comments, like, poll)
    val url: String = "" //URL с которого была опубликована запись
}

object Geo {
    val type: String = "" // тип места
    val coordinates: String = "" // Координаты места
}

interface Attachment {
    val type: String
}

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String
)

data class PhotoAttachment(val photo: Photo) : Attachment {
    override val type = "photo"
}

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int

)

data class VideoAttachment(val video: Video) : Attachment {
    override val type = "video"
}

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int
)

data class AudioAttachment(val audio: Audio) : Attachment {
    override val type = "audio"
}

data class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    val previewPage: String
)

data class LinkAttachment(val link: Link) : Attachment {
    override val type = "link"
}

data class Graffiti(
    val id: Int,
    val ownerId: Int,
    val url: String,
    val width: Int,
    val height: Int
)

data class GraffitiAttachment(val grafiti: Graffiti) : Attachment {
    override val type = "graffiti"
}


object WallService {

    private var postId: Int = 0
    var posts = emptyArray<Post>()

    fun add(post: Post): Post {

        val postUniqueId = postId + 1
        posts += post
        postId++
        return posts[postUniqueId - 1]
    }

    fun update(newpost: Post): Boolean {
        val checkedId = newpost.id
        for ((index, post) in posts.withIndex())
            if (checkedId == post.id) {

                posts[index] = newpost.copy(
                    77,
                    21,
                    33,
                    66,
                    1685030715,
                    "Пост Тест",
                    55,
                    58,
                    true,
                    Comments,
                    " 1234",
                    Likes,
                    Reposts,
                    Views,
                    "qwe",
                    PostSource,
                    Geo,
                    33,
                    true,
                    true,
                    true,
                    true,
                    true,
                    true,
                    88
                )
                return true
            }
        return false
    }

    operator fun set(index: Int, value: Post) {
        posts[index] = value
    }

    fun clear() {
        posts = emptyArray()
        postId = 0
    }

    fun print() {
        println(posts.joinToString())
    }
}


fun main() {

    val comments = Comments
    val likes = Likes
    val reposts = Reposts
    val views = Views
    val postSource = PostSource
    val geo = Geo

    val post1 = Post(
        1,
        21,
        33,
        66,
        1685030715,
        "Пост 1",
        55,
        58,
        true,
        comments,
        " 1234",
        likes,
        reposts,
        views,
        "qwe",
        postSource,
        geo,
        33,
        true,
        true,
        true,
        true,
        true,
        true,
        88
    )
    val post2 = Post(
        2,
        21,
        33,
        66,
        1685030715,
        "Пост 2",
        55,
        58,
        true,
        comments,
        " 1234",
        likes,
        reposts,
        views,
        "qwe",
        postSource,
        geo,
        33,
        true,
        true,
        true,
        true,
        true,
        true,
        88
    )
    val post3 = Post(
        3,
        21,
        33,
        66,
        1685030715,
        "Пост 3",
        55,
        58,
        true,
        comments,
        " 1234",
        likes,
        reposts,
        views,
        "qwe",
        postSource,
        geo,
        33,
        true,
        true,
        true,
        true,
        true,
        true,
        88
    )
    val post4 = Post(
        4,
        21,
        33,
        66,
        1685030715,
        "Пост 4",
        55,
        58,
        true,
        comments,
        " 1234",
        likes,
        reposts,
        views,
        "qwe",
        postSource,
        geo,
        33,
        true,
        true,
        true,
        true,
        true,
        true,
        88
    )

    val postTest = Post(
        1,
        21,
        33,
        66,
        1685030715,
        "Пост Тест",
        55,
        58,
        true,
        comments,
        " 1234",
        likes,
        reposts,
        views,
        "qwe",
        postSource,
        geo,
        33,
        true,
        true,
        true,
        true,
        true,
        true,
        88
    )

    WallService.add(post1)
    WallService.add(post2)
    WallService.add(post3)
    WallService.add(post4)


    WallService.print()
    println("#############")
    println(WallService.update(postTest))
    WallService.print()

}