1.Creează un fișier JSON care să conțină date în formatul celor prezentate în capitolul exemplu_de_json. Scrie o aplicație care să citească datele din acest fișier și să le translateze într-un obiect Java (hints: JAXB, Jackson).
2.Creează un fișier JSON care să conțină un array de date în formatul celor prezentate în capitolul exemplu_de_json. Scrie o aplicație care să citească datele din acest fișier și să le translateze într-un array de obiecte Java.
3.Creează un endpoint de tip POST pentru path-ul /messages. Acesta trebuie să primească, prin request body, un JSON de forma:
{
    "sender": "Ion Popescu",
    "receiver": "Dan Ionescu",
    "text": "Salut! Ce mai faci?",
    "seen": false,
    "sentDate": "2022-03-27T11:34:40+00:00"
}
3.a.Dacă request-ul conține un header numit authentication, cu valoarea devmind-api-key, atunci endpoint-ul va întoarce status code 201.
3.b.Dacă header-ul authentication lipsește sau are altă valoare, endpoint-ul va întoarce status code 401.
4.Creează cel puțin 2 request-uri folosind Postman care să valideze scenariile de la punctul anterior.
