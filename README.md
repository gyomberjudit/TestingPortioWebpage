# TestingPortioWebpage

### Vizsgaremek - A Portio weboldal automata tesztelése
Készítette: Gyömbér Csabáné

Mentor: Lenner Tamás

Képző intézmény: Coodcool

Képzés: Junior Automata Tesztelő

### **Hasznos linkek:**
Tesztelt weboldal elérhetősége: https://lennertamas.github.io/portio/

GitHub repository elérhetősége: https://github.com/gyomberjudit/TestingPortioWebpage.git

Allure Report elérhetősége: https://gyomberjudit.github.io/TestingPortioWebpage

Tesztmenedzser táblázat: https://github.com/gyomberjudit/TestingPortioWebpage/blob/master/test_case_template.xlsx

### **Használt technológia:**
Java, IntelliJ IDEA, JUnit 5, Maven, Selenium, WebDriver, ChromeDriver,

Github Actions, CI/CD Workflow, Allure report

### **Tesztelt funkciók:**
- reisztráció
- bejelentkezés
- adatkezelési nyilatkozat használata
- adatok listázása
- többoldalas lista bejárása
- új adat bevitel
- ismételt és sorozatos adatbevitel adatforrásból
- meglévő adat módosítása
- adatok törlése
- adatok lementése felületről
- navigáció
- kijelentkezés

### Felépítés:
- ###### _src/ main/ java/ utilPages:_   BasePage ősosztály, Pages enum 
- ###### _scr/ main/ java/ pages:_       Page osztályok, melyek a BasePage leszármazottai

- ###### _src/ test/ java/ testEnvironment:_  BaseTest ősosztály
- ###### _src/ test/ java/ tests:_            Test osztályok, melyek a BaseTest leszármazottai

### Tesztek futtatásának módja:

A GitHub repository klónozása után a teszteket java környezetben javasolt futtatni (Pl. IntelliJ IDEA).

Az automata futás az Allure Report fentebb található elérhetőségén tekinthető meg.