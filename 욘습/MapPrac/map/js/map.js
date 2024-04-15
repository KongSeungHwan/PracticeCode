var geocoderDaum = new daum.maps.services.Geocoder();
var map = null;
(function(){
    searchMyPoint();
})();
async function searchMyPoint(){
    try {
        var position = await getCurrentPosition();
        var latitude = position.coords.latitude;
        var longitude = position.coords.longitude;
        document.getElementById('lat').value=latitude;
        document.getElementById('lon').value=longitude;
        var address = await getCurrentAddress(latitude,longitude);
        document.getElementById('address').value=address;
        loadMap(latitude,longitude,"현재 내 위치");

    } catch(error) {
        console.error("Error getting current position:", error);
    }
}

async function getCurrentPosition(){
    return await new Promise((resolve, reject) => {
        navigator.geolocation.getCurrentPosition(resolve, reject);
    });
};

const getCurrentAddress = async (latitude, longitude) => {
    try {
        const response = await fetch(`https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x=${longitude}&y=${latitude}`, {
            headers: {
                Authorization: `KakaoAK 04076bec2077f5bf9e3ea19dbea286d2`,
            },
        });
        const data = await response.json();
        const region1depthName = data?.documents[0]?.region_1depth_name || '';
        const region2depthName = data?.documents[0]?.region_2depth_name || '';
        const region3depthName = data?.documents[0]?.region_3depth_name || '';
        const address = region1depthName+" "+region2depthName+" "+region3depthName;
        return address;
    } catch (error) {
        throw new Error('Failed to get current city');
    }
};


function searchAddress() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = data.address; // 최종 주소 변수

            // 주소로 상세 정보를 검색
            geocoderDaum.addressSearch(data.address, function(results, status) {
                // 정상적으로 검색이 완료됐으면
                if (status === daum.maps.services.Status.OK) {
                    var result = results[0]; //첫번째 결과의 값을 활용
                    var coords = new daum.maps.LatLng(result.y, result.x);
                    var longitude = coords.getLng().toString();
                    var latitude = coords.getLat().toString();
                    document.getElementById('address').value=result.address.address_name;
                    document.getElementById('lat').value=latitude;
                    document.getElementById('lon').value=longitude;
                    loadMap(latitude,longitude,"검색 주소 위치");
                }
            });
        }
    }).open();
}

function loadMap(lat,lon,title) {
	var mapContainer = document.getElementById('map');
    var defaultLatLng = new kakao.maps.LatLng(lat, lon);
	var mapOption = { 
		center: defaultLatLng,
		level: 2
	};
	map = new kakao.maps.Map(mapContainer, mapOption);
    map.setCenter(defaultLatLng);
	map.setMaxLevel(13);
    createCompMapItem(lat,lon,title);
}



function createCompMapItem(lat,lon,title) {
    var markerImageSrc = "./img/markerIcon.png";
	var markerImageSize = new kakao.maps.Size(30, 30);
	var markerImageOptions = {
        offset: new kakao.maps.Point(20,0),
		alt: '지도 마커 이미지'
	};
	
	var markerIamge = createMarkerImage(markerImageSrc, markerImageSize, markerImageOptions);
	
	var markerPosition = new kakao.maps.LatLng(lat,lon);
	var marker = new kakao.maps.Marker({
        position: markerPosition,
		image: markerIamge,
        title: title,
		zIndex: 2
	});
	
	marker.setMap(map);
}

function createMarkerImage(src, size, options) {
    var markerImage = new kakao.maps.MarkerImage(src, size, options);
    return markerImage;
}