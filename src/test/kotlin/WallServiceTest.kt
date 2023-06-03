import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class WallServiceTest {


    @Test
    fun add() {
        var postId: Int = 0

        val postUniqueId = postId + 1

        assertEquals(1, postUniqueId)

    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()

    }


    @Test
    fun updateFalse() {
        val comments = Comments
        val likes = Likes
        val reposts = Reposts
        val views = Views
        val postSource = PostSource
        val geo = Geo

        val post1 = Post(1, 21, 33, 66, 1685030715, "Пост 1", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)
        val post2 = Post(2, 21, 33, 66, 1685030715, "Пост 2", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)
        val post3 = Post(3, 21, 33, 66, 1685030715, "Пост 3", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)
        val post4 = Post(4, 21, 33, 66, 1685030715, "Пост 4", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)

        val postTest = Post(7, 21, 33, 66, 1685030715, "Пост Тест", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)

        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)
        WallService.add(post4)

        val result = WallService.update(postTest)

        assertEquals(false, result)
    }

    @Test
    fun updateTrue() {
        val comments = Comments
        val likes = Likes
        val reposts = Reposts
        val views = Views
        val postSource = PostSource
        val geo = Geo

        val post1 = Post(1, 21, 33, 66, 1685030715, "Пост 1", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)
        val post2 = Post(2, 21, 33, 66, 1685030715, "Пост 2", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)
        val post3 = Post(3, 21, 33, 66, 1685030715, "Пост 3", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)
        val post4 = Post(4, 21, 33, 66, 1685030715, "Пост 4", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)

        val postTest = Post(2, 21, 33, 66, 1685030715, "Пост Тест", 55, 58, true, comments, " 1234", likes, reposts, views, "qwe", postSource, geo, 33, true, true, true, true, true, true, 88)

        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)
        WallService.add(post4)

        val result = WallService.update(postTest)

        assertEquals(true, result)
    }
}