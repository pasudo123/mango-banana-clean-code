package `010-class`.`001-클래스는_작아야_한다`.`best-model`

import java.time.LocalDateTime

/**
 * 게시판 하나의 게시글에 대한 담고 있는 데이터가 많다.
 * 이걸 분리하는 것이 관건이다.
 */
class Post {
    var content: String = ""
    var createdBy: String = ""
    val createdAt: LocalDateTime = LocalDateTime.now()
    var modifiedAt: LocalDateTime = LocalDateTime.now()
    val comments: List<String> = mutableListOf()
    val pictures: List<String> = mutableListOf()
    val videos: List<String> = mutableListOf()
    var version: String = ""
}