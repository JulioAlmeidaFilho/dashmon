function carregarusuario(){
    // Java => Objeto
    // Javascript => Json
    // HTML => String
    
    var usuariostr = localStorage.getItem("usuariologado");

  
    if (usuariostr!=null){
        var usuariojson = JSON.parse(usuariostr);
        
        document.getElementById("foto").innerHTML =
        "<img src=../imagens/" + usuariojson.linkFoto + ">";

        document.getElementById("dados").innerHTML =
        "<h3>" + usuariojson.nome + " (" + usuariojson.racf + ")" + "<br>" +
        usuariojson.email + "</h3>";

    }else{
        window.location="login.html";
    }





}







function logar() {
    //Get ou post? - Post
    var carta = {
        "email": document.getElementById("txtemail").value,
        "racf": document.getElementById("txtemail").value,
        "senha": document.getElementById("txtsenha").value
    }

    //Definindo o envelope
    var envelope = {
        method: "POST",
        body: JSON.stringify(carta),
        headers: {
            "content-type": "application/json"
        }
    }

    fetch("http://localhost:8080/login", envelope)
        .then(res => res.json())
        .then(res => {
            localStorage.setItem("usuariologado",JSON.stringify(res));
            window.location = "usuario.html";
        })
        .catch(err => {
            window.alert("Não foi possivel logar")
        });


}
