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
        val like1 = Likes

        val post1 = Post(1, 31, 50, 1685030715, "Привет, Мир1!", true, true, false, false, like1)
        val post2 = Post(2, 32, 60, 1685030716, "Привет, Мир2!", true, true, false, false, like1)
        val post3 = Post(3, 33, 70, 1685030717, "Привет, Мир3!", true, true, false, false, like1)
        val post4 = Post(4, 34, 80, 1685030717, "Привет, Мир4!", true, true, false, false, like1)
        val postTest = Post(7, 34, 80, 1685030717, "Привет, Мир4!", true, true, false, false, like1)

        WallService.add(post1)
        WallService.add(post2)
        WallService.add(post3)
        WallService.add(post4)

        val result = WallService.update(postTest)

        assertEquals(false, result)
    }

    @Test
    fun updateTrue() {
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

        val result = WallService.update(postTest)

        assertEquals(true, result)
    }
}