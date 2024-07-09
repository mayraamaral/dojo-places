(() => {
    const cepInput = document.getElementById("cep");

    cepInput.addEventListener("blur", () => {
        fetch("https://viacep.com.br/ws/" + cepInput.value + "/json")
            .then(response => response.json())
            .then(data => {
                document.getElementById("bairro").value = data.bairro;
                document.getElementById("cidade").value = data.localidade;
            })
            .catch(error => {
                console.error('Erro ao buscar CEP:', error);
            });
    })
})();