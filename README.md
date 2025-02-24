# Gimtadienio kalendoriaus programa

## Aprasimas
Sis projectas yra mano bandymas prisiminti man svarbiu zmoniu gimtadienius, Ji esu pristates kaip savo, Vinius Coding School baigemaji darba. Pavyko pristatyti visai gerai. Po pristatimo dar programa naudojau, bet po imetimo telefoni i tuoleda ir vienitelei versijei kuri veike pradingus supratau kad reikia is naujo padaryti ji porjecta. Tai tai ir pradejau daryti

Projectavimo metu buvo pareikalauta kad naudotumia room duomenu bazia, Tai pagrindinis darbas bus su ja. O as is saves visada norejua pritaikti spalbinguma, ir taip sakoma **Dark mode** bei is systemos pasiimti jos spalvas ir prisitaikiti prie mobilaius yrenginio stiliaus

## Struktura

Kadangi dirbau su **IntelJ** ir **Andriod Studijo**, tai bandysiu paiskinti su ju naudojimo langais. Taip pat is Android strukturos lango

Yra trys darlys sios programos:
- Duomenu baze
  - Kadangi pagal orginalu plana man jos reikejo daugiau. Saugant naudotojo duomenis kaip vardus, metus, emailus, spalvas, bet dabar palikau tik svarbiausia data, tai galimai si dalis yra tustoka
- Front-end logica 
  - Pagrinde tesiog kaip veikia naudotojo paspaudimai, kaip reguoja mobilus irnginys i paspaudimus. Is esmes Animacijos, Kiekvienas langas turi savo Classia kuri yra savamia failaia ir tenais atsakingia uz savo darba
- Privati informacija
  - Tesiog nenorejua i github ideti zmoniu gimtadieniu, tai sukuriau atskira klasia

## Veikimo Logika

- [x] Naudotojas paleides pirma kaerta programa, leidzia pasirinkti savo gimtadienio sarasa, Bet kolkas veikia tik su MarkDown failas, del to jo pavidys ir bus. MD failo struktura turi prasideti taip:

```markdown
|Aa|Bb|Cc|Dd|
| - | - | - | - |
| | | | |
```

- [ ] Failo nepasirinkus neleidizia testi darbo, reikalauja kad su kita programa sukurtas butu failas ir ikeltas. Jei nezino kaip turi atroditi struktura parodyti pavizdini faila
- [x] Pagrindiniamia lange aiskiai yra rodoma informa apie gimtadieni
- [ ] Sutvarkyti Top bar stiliu kad atrodytu normaliai
- [ ] Sukurti Dark mode, kurs dinamiskai arba rankiniu buvu keiciasi
- Pasiimti spalbas is sistemos 