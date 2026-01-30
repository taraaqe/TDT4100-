# Gyldig tilstand - LineEditor-oppgave med fri peker

Oppgaven utvider [Tilstand og oppførsel - LineEditor-oppgave](../oving1/LineEditor.md) med validering.

Denne oppgaven tar utgangspunkt i [Tilstand og oppførsel - LineEditor-oppgave](../oving1/LineEditor.md) og utvider `LineEditor`-klassen med metoder for å endre teksten og tekstinnsettingsposisjonen direkte, så det blir  enklere å gjøre om tilstanden til objektet.

Dersom du ikke har gjort [LineEditor-oppgaven](../oving1/LineEditor.md), bør du gjøre den først. Løsningsforslag til denne oppgaven kommer til å bli tilgjengelig [her](https://git.ntnu.no/tdt4100/tdt4100-lf-25/blob/main/src/main/java/oving1/LineEditor.java) etter siste demonstrasjonsfrist for øving 1.

Endringer:

- Når teksten endres skal tekstinnsettingsposisjonen settes til å være bak teksten.
- Det skal ikke være mulig å passere `null` som tekst.

Hvordan vil du implementere dette med én eller flere metoder, inkludert valideringsmetode(r), slik at en er sikret at `LineEditor`-objekter aldri blir ugyldige?

Testkode for denne oppgaven finner du her: [oving2/LineEditorTest.java](../../src/test/java/oving2/LineEditorTest.java).
