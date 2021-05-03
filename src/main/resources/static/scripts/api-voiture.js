function loadCar() {
    $.ajax({
        "type": 'GET',
        "url" : '/voitures',
        "headers": {
            "Content-Type": 'application/json'
        },
        "dataType": 'json',
        success: function(payload) {
            payload.forEach(function(index) {
            $(".list").append(
            '<div class="col-sm-4">'+
              '<div class="panel panel-primary">'+
                  '<div class="panel-heading">Type  : '+ index.type +'</div>'+
                  '<div class="panel-body">'+
                      '<div class="card-header py-2">'+
                           '<h6 >Marque  : <span>'+index.marque+'</span></h6>'+
                           '<h6 >Couleur : <span>'+index.couleur+'</span></h6>'+
                           '<h6 >Poids   : <span>'+index.poids+' kg</span></h6>'+
                           '<h6 >Capacite du Réservoir : <span>'+index.capaciteReservoir+'</span></h6>'+
                       '</div>'+
                  '<div class="panel-footer"><a href="/voiture/'+index.id+'" class="btn-sm-primary detailBtn"><span></span> Détails</a></div>'+
              '</div>'+
            '</div>'
                 );
            });
        },
        error: function(error) {

        }
    });
}

function detail(id) {
    $.ajax({
        "type": 'GET',
        "url" : '/voitures/findById/'+id,
        "headers": {
            'Content-Type': 'application/json'
        },
        "dataType": 'json',
        success: function(payload) {
            payload.forEach(function(index){
                $(".detail").append(
                '<div class="row">'+
                    '<div class="col-sm-12">'+
                        '<div class="panel panel-default text-left">'+
                            '<div class="panel-body">'+
                                '<div class="card-header py-2">'+
                                   '<h6 >Marque  : <span>'+index.marque+'</span></h6>'+
                                   '<h6 >Couleur : <span>'+index.couleur+'</span></h6>'+
                                   '<h6 >Poids   : <span>'+index.poids+' kg</span></h6>'+
                                   '<h6 >Capacite du Réservoir : <span>'+index.capaciteReservoir+'</span></h6>'+
                                '</div>'+
                                '<br><br></hr>'+
                                '<h3 >Marque  : <span>Moteur</span></h3>'+
                                '<p contenteditable="true">Alimentation : '+index.moteur.alimentation+'</p>'+
                                '<p contenteditable="true">Carburant    : '+index.moteur.carburant+'</p>'+
                                '<p contenteditable="true">Cylindrée    : '+index.moteur.cylindree+'</p>'+
                                '<br><br></hr>'+
                                '<h3 >Marque  : <span>Dimension</span></h3>'+
                                '<p contenteditable="true">Dimensions  : '+index.dimension.dimensions+'</p>'+
                                '<p contenteditable="true">Empattement : '+index.dimension.empattement+'</p>'+
                                '<button type="button" class="btn btn-default btn-sm">'+
                                    '<span class="glyphicon glyphicon-thumbs-up"></span> Like'+
                                '</button>'+
                            '</div>'+
                        '</div>'+
                    '</div>'+
                '</div>'
                );
            });
        },
        error: function(error) {
            alert(error);
        }
    });
}

function findById(id) {
    $.ajax({
        "type": 'GET',
        "url" : '/voitures/findById/'+id,
        "headers": {
            'Content-Type': 'application/json'
        },
        "dataType": 'json',
        success: function(payload) {
            alert(payload);
        },
        error: function(error) {
            alert(error);
        }
    });
}

jQuery(document).ready(function() {
    loadCar();
});