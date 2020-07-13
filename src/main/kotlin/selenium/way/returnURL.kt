package selenium.way

private val kgURL: String = "https://eduro.goe.go.kr/stv_cvd_co00_002.do" //경기도
private val bsURL: String = "https://eduro.pen.go.kr/stv_cvd_co00_002.do" //부산
private val slURL: String = "https://eduro.sen.go.kr/stv_cvd_co00_002.do" //서울
private val unURL: String = "https://eduro.use.go.kr/stv_cvd_co00_002.do" //울산
private val dgURL: String = "https://eduro.dge.go.kr/stv_cvd_co00_010.do" //대구
private val jnURL: String = "https://eduro.jne.go.kr/stv_cvd_co00_002.do" //전라남도
private val jbURL: String = "https://eduro.jbe.go.kr/stv_cvd_co00_002.do" //전라북도
private val gjURL: String = "https://eduro.gen.go.kr/stv_cvd_co00_002.do" //광주광역시
private val kbURL: String = "https://eduro.gbe.kr/stv_cvd_co00_002.do" //경상북도
private val knURL: String = "https://eduro.gne.go.kr/stv_cvd_co00_002.do" //경상남도
private val icURL: String = "https://eduro.ice.go.kr/stv_cvd_co00_002.do" //인천
private val sjURL: String = "https://eduro.sje.go.kr/stv_cvd_co00_002.do" //세종
private val jjURL: String = "https://eduro.jje.go.kr/stv_cvd_co00_002.do" //제주도
private val djURL: String = "https://eduro.dje.go.kr/stv_cvd_co00_002.do" //대전
private val cbURL: String = "https://eduro.cbe.go.kr/stv_cvd_co00_002.do" //충북
private val cnURL: String = "https://eduro.cne.go.kr/stv_cvd_co00_002.do" //충남
private val kwURL: String = "https://eduro.kwe.go.kr/stv_cvd_co00_002.do" //강원도

internal fun returnURL(location: String): String {
    when(location) {
        "경기도" -> return kgURL
        "부산광역시" -> return bsURL
        "서울특별시" -> return slURL
        "울산광역시" -> return unURL
        "대구광역시" -> return dgURL
        "전라남도" -> return jnURL
        "전라북도" -> return jbURL
        "광주광역시" -> return gjURL
        "경상북도" -> return kbURL
        "경상남도" -> return knURL
        "인천광역시" -> return icURL
        "세종특별시" -> return sjURL
        "제주특별자치도" -> return jjURL
        "대전광역시" -> return djURL
        "충청북도" -> return cbURL
        "충청남도" -> return cnURL
        "강원도" -> return kwURL
        else -> return "invalid location"
    }
}