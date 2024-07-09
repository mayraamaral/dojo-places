(() => {
    const cepInput = document.getElementById("cep");

    const toastHtml = `        
        <div id="toast-error-cep" class="d-flex justify-content-end pt-4 px-4">
            <div class="alert alert-danger col-md-2" role="alert" >
                CEP não encontrado
            </div>
        </div>`;

    cepInput.addEventListener("blur", () => {
        fetch("https://viacep.com.br/ws/" + cepInput.value + "/json")
            .then(response => response.json())
            .then(data => {
                document.getElementById("bairro").value = data.bairro;
                document.getElementById("cidade").value = data.localidade;
            })
            .catch(error => {
                document.body.insertAdjacentHTML('afterbegin', toastHtml);
                console.error('Erro ao buscar CEP:', error);
            });
    })


})();