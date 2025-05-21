// Évszám megjelenítése és betöltési üzenet
document.addEventListener("DOMContentLoaded", function () {
    console.log("Oldal betöltve!");
    const evSpan = document.getElementById("ev");
    if (evSpan) {
        evSpan.textContent = new Date().getFullYear();
    }
});

// Űrlap ellenőrzés
function validateForm() {
    const vezeteknev = document.getElementById("vnev").value.trim();
    const utonev = document.getElementById("unev").value.trim();
    const email = document.getElementById("email").value.trim();
    const telefon = document.getElementById("tel").value.trim();
    const megjegyzes = document.getElementById("megjegyzes").value.trim();

    if (!vezeteknev || !utonev || !email || !telefon || !megjegyzes) {
        alert("Kérem töltse ki az összes mezőt!");
        return false;
    }

    alert("Köszönjük, hogy megkeresett minket, hamarosan felvesszük Önnel a kapcsolatot!");
    return true;
}
