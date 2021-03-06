// google-map
// Initialize and add the map
function initMap() {
    // The map, centered at myLatLng
    const map = new google.maps.Map(document.getElementById("mapBox"), {
        zoom: 8,
        center: { lat: 35.70410420663528, lng: 139.77242657030774 },
    });
    
    setMarKers(map);
}

//Place List
const isyuukans = [
    ["Nishiba", 35.70410420663528, 139.77242657030774, 1],
    ["埼玉｜医修館", 35.93933743697428, 139.4200116547968, 2 ],
    ["横浜", 35.45806460812385, 139.5777527942403]
];

//multiple markers& open direction
function setMarKers(map){
    for (let i = 0; i < isyuukans.length; i++) {
        const isyuukan = isyuukans[i];

        var marker = new google.maps.Marker({
            position: { lat: isyuukan[1], lng: isyuukan[2] },map,
            title: isyuukan[0],
            // label: {
            //     text: isyuukan[0],
            //     color: "#000000",
            //     fontweight: "bold",
            // },
            zIndex: isyuukan[3],
            
        });
    }
    
}

// let searchR
// function searchRoad{
//     searchR = window.open
// }

window.initMap = initMap;