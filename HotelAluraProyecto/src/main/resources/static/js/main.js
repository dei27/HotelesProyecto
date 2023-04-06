// Verifica si el navegador soporta la API Web Speech
if ('webkitSpeechRecognition' in window) {
	// Obtiene el elemento donde se mostrará el texto seleccionado
	var textoSeleccionado = document.getElementById('texto-seleccionado');
	var currentUtterance = null; //almacena la síntesis de voz actual

	// Agrega un evento de teclado a la página
	document.addEventListener('keydown', function(event) {
		// Verifica si la tecla presionada es la tecla "L"
		if (event.keyCode == 76) {
			// Obtiene el texto seleccionado
			var seleccion = window.getSelection().toString();

			// Si hay texto seleccionado
			if (seleccion) {
				// Detiene la síntesis de voz actual, si hay alguna
				if (currentUtterance) {
					window.speechSynthesis.cancel(currentUtterance);
				}

				// Muestra el texto seleccionado en la página
				textoSeleccionado.innerText = seleccion;

				// Lee el texto seleccionado en voz alta
				var synthesizer = window.speechSynthesis;
				var utterance = new SpeechSynthesisUtterance(seleccion);
				utterance.lang = 'es-MX'; // idioma en el que se va a leer el texto
				currentUtterance = utterance; // actualiza la síntesis de voz actual
				synthesizer.speak(utterance);
			}
		}
	});
}

document.addEventListener('keydown', function(event) {
  if (event.keyCode == 27) { // 27 es el código de la tecla Esc
    var synthesizer = window.speechSynthesis;
    if (synthesizer.speaking) {
      synthesizer.cancel();
    }
  }
});


document.getElementById('aumentar-btn').addEventListener('click', function() {
  var zoomActual = parseFloat(document.body.style.zoom) || 1;
  zoomActual += 0.1;
  document.body.style.zoom = zoomActual;
});

document.getElementById('reducir-btn').addEventListener('click', function() {
  var zoomActual = parseFloat(document.body.style.zoom) || 1;
  zoomActual -= 0.1;
  document.body.style.zoom = zoomActual;
});

document.getElementById('restablecer-btn').addEventListener('click', function() {
  document.body.style.zoom = 1;
});






