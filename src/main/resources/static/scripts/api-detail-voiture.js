function loadDetail(id) {
    $.ajax({
        "type": 'GET',
        "url" : '/voitures/findById/'+id,
        "headers": {
            'Content-Type': 'application/json'
        },
        "dataType": 'json',
        success: function(payload) {
                $(".detail").append(
                    '<div class="col-sm-12">'+
                        '<div class="panel panel-default text-left">'+
                            '<div class="panel-body">'+
                                '<h5 >Marque  : <span>'+payload.marque+'</span></h4>'+
                                '<h4 >Couleur : <span>'+payload.couleur+'</span></h4>'+
                                '<h4 >Poids   : <span>'+payload.poids+' kg</span></h4>'+
                                '<h4 >Capacite du Réservoir : <span>'+payload.capaciteReservoir+'</span></h4>'+
                                '<br>'+
                                '<div class="card-header py-2">'+
                                    '<h3 ><span>Moteur : </span></h3>'+
                                    '<h6 contenteditable="true">Alimentation : '+payload.moteur.alimentation+'</h6>'+
                                    '<h6 contenteditable="true">Carburant    : '+payload.moteur.carburant+'</h6>'+
                                    '<h6 contenteditable="true">Cylindrée    : '+payload.moteur.cylindree+'</h6>'+
                                    '<br>'+
                                    '<h3 ><span>Dimensions : </span></h3>'+
                                    '<h6 contenteditable="true">Dimensions  : '+payload.dimension.dimensions+'</h6>'+
                                    '<h6 contenteditable="true">Empattement : '+payload.dimension.empattement+'</h6>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                    '</div>'
                );
        },
        error: function(error) {
            alert(error);
        }
    });
}

function loadComment(id) {
    $.ajax({
        "type": 'GET',
        "url" : '/comment/findByCar/'+id,
        "headers": {
            'Content-Type': 'application/json'
        },
        "dataType": 'json',
        success: function(payload) {
            payload.forEach(function(index){
                $(".commentblock").append(
                '<div class="col-sm-3">'+
                    '<div>'+
                        '<p>'+index.user.pseudo+'</p>'+
                    '</div>'+
                '</div>'+
                '<div class="col-sm-9">'+
                    '<div>'+
                        '<h6>' + index.commentaires + ' .Ajoutée le : ' + index.dateCreation + '</h6>'+
                    '</div>'+
                '</div>'
                );
            });
        }
    });
}

function addComment() {
    $.ajax({
        "url": '/comment/add',
        "type": 'POST',
        "headers": {
            'Content-Type': 'application/json'
        },
        "dataType": 'json',
        data: JSON.stringify({
           "commentaires": $("#comment").val(),
           "voiture": {
                "id": $("#idCar").val()
           },
           "user": {
                "id": 1
           }
        }),
        success: function(data) {
        console.log("success");
            location.href = window.location.origin + "/voiture/"+ $("#idCar").val();
        },
        error: function(error) {
            location.href = window.location.origin + "/voiture/"+ $("#idCar").val();
            console.log(error)
        }
    });
}

var idCar;
jQuery(document).ready(function() {
    idCar = $("#idVoiture").val();
    loadDetail(idCar);
    loadComment(idCar);

    $(".sendComment").on('click', function(event) {
        addComment();
    });
});