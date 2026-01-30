# Innkapsling - Account-oppgave

Oppgaven er en innkapslet og litt utvidet variant av [Account-oppgaven](../oving1/Account.md) under temaet [Tilstand og oppførsel](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=65937373), og stiller blant annet større krav til validering.

Dersom du ikke har gjort [Account-oppgaven](../oving1/Account.md), bør du gjøre den først. Løsningsforslag til denne oppgaven kommer til å bli tilgjengelig [her](https://git.ntnu.no/tdt4100/tdt4100-lf-25/blob/main/src/main/java/oving1/Account.java) etter siste demonstrasjonsfrist for øving 1.

Et `Account`-objekt inneholder data om beløpet som står på kontoen og rentefoten (prosentpoeng).

Begge verdiene skal oppgis og settes når objektet opprettes og ingen av verdiene kan være negative.

`Account`-klassen har metoder for å sette inn og ta ut beløp, og legge til påløpte renter, i tillegg til en konstruktør for å initialisere en ny konto. Alle disse skal utløse unntak av typen `IllegalArgumentException`, dersom et argument ikke tilfredstiller kravene som angis.

- `Account(double, double)` - konstruktøren skal ta inn startbeløpet og rentefoten (prosentpoeng). Ingen av disse kan være negative.
- `double getBalance()` - returnerer beløpet som står på kontoen.
- `double getInterestRate()` - returnerer renten på kontoen.
- `void setInterestRate(double)` - denne metoden tar inn en ikke-negativ verdi og setter renten til denne verdien.
- `void deposit(double)` - denne metoden tar inn et ikke-negativt beløp og øker konto-beløpet tilsvarende.
- `void withdraw(double)` - denne metoden tar inn et ikke-negativt beløp og minsker konto-beløpet tilsvarende. Dersom det nye konto-beløpet er negativt, så skal tilstanden ikke endre, og det skal utløses et unntak av typen `IllegalArgumentException`.
- `void addInterest()` - beregner renta og legger det til konto-beløpet.

## Leseliste

- [Gyldig tilstand](https://www.ntnu.no/wiki/display/tdt4100/Gyldig+tilstand) - Tilstanden til et objekt er verdien av alle attributtene. En viktig del av [oppførselen til et objekt](https://www.ntnu.no/wiki/pages/viewpage.action?pageId=65937373) er å sikre at tilstanden til objektet alltid er _gyldig_, dvs. at alle attributtene har gyldige/konsistente verdier.
- [Innkapsling](https://www.ntnu.no/wiki/display/tdt4100/Innkapsling) - Innkapsling er en programmeringsteknikk som har som formål å hindre direkte tilgang til tilstanden til et objekt fra objekter av andre klasser.
- [Koding av valideringsmetoder](https://www.ntnu.no/wiki/display/tdt4100/Koding+av+valideringsmetoder) - En valideringsmetode har som formål å sjekke om en eller flere verdier er gyldige, slik at dette kan sjekkes av f.eks. setter-metoder før tilsvarende attributter evt. settes.

## Del 1: Innkapsling og validering - Teori

Ta utgangspunkt i koden fra [Account](../oving1/Account.md)-klassen og besvar følgende spørsmål:

- Forklar hvorfor metodene over kan sies å være en komplett innkapsling av tilstanden?
- Er denne klassen data-orientert eller tjeneste-orientert? Begrunn svaret!

## Del 2 - Java-kode

Implementer endringene fra [Account](../oving1/Account.md)-klassen i den nye `Account`-klassen med oppførsel som beskrevet over.

Testkode for denne oppgaven finner du i [oving2/AccountTest.java](../../src/test/java/oving2/AccountTest.java).
