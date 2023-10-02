<?php
// 데이터베이스 연결 설정
$servername = "ewha02guidebook.cafe24.com:3306";
$username = "ewha02guidebook";
$password = "guidebook23!";
$dbname = "ewha02guidebook";

// MySQL 연결
$conn = new mysqli($servername, $username, $password, $dbname);

// 연결 오류 확인
if ($conn->connect_error) {
    die("연결 실패: " . $conn->connect_error);
}

// 검색어 가져오기
$query = $_GET['query'];

// 데이터베이스에서 검색 결과 조회 (예시: department_name 컬럼을 사용하여 검색)
$sql = "SELECT majorName FROM major_table WHERE majorName LIKE '%$query%'";
$result = $conn->query($sql);

// 결과를 배열로 저장
$results = array();
if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        $results[] = $row['majorName'];
    }
}

// JSON 형식으로 결과 반환
header('Content-Type: application/json');
echo json_encode($results);

// 데이터베이스 연결 종료
$conn->close();
?>
