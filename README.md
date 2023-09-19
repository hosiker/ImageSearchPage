# ImageSearchPage

## 과제 설명

이미지를 검색해서 보관함에 수집하는 안드로이드 앱

- 이미지를 검색해서 보관함에 수집하는 안드로이드 앱을 작성해주세요.
- 검색은 키워드를 입력하고 검색을 누르면 이미지 검색 결과 리스트를 보여줍니다.
- 이미지 검색 API ( https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-image ) 의 thumbnail_url 필드
- UI는 fragment 2개를 사용합니다. (버튼이나 탭 선택 시 전환)

- 첫 번째 fragment : 검색 결과
- 검색어를 입력할 수 있습니다.
- 검색된 이미지 리스트가 나타납니다. 각 아이템에는 이미지와 함께 날짜와 시간을 표시합니다.

       - 검색 결과는 최대 80개까지만 표시합니다.

       - 리스트에서 특정 이미지를 선택하여 '내 보관함'으로 저장할 수 있습니다.
       - 이미 보관된 이미지는 특별한 표시를 보여줍니다. (좋아요/별표/하트 등)
       - 보관된 이미지를 다시 선택하여 보관함에서 제거 가능합니다.

- 두 번째 fragment: 내 보관함
- 검색 결과에서 보관했던 이미지들 보입니다.

- 마지막 검색어는 저장되며, 앱 재시작시 마지막 검색어가 입력 필드에 자동으로 입력됩니다.

## 개발 요건
- 검색 데이터는 https://developers.kakao.com/product/search 의 Open API를 사용합니다.
- 오픈 소스 사용 가능합니다. (glide등..)
