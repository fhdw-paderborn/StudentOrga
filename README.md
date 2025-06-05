# TODO
 - Abstract Class / Interface
 - Geschachtelte Klassen
 - Konstanten und enums

 - Exception Handling
 - Generics
 - Collections

 - Lambda / Streams / Options
 - Dateien / Datenströme
 - Serialisierung
 
 - HTTP
----

 - Swing UI für Shapes
 - Frontend: Electron - Backend Java
 - Beispiel: Account Savings


# Student Organization System

Eine Java-Anwendung zur Verwaltung von Personen, Studenten und Dozenten.

## Projektstruktur

Das Projekt folgt einer klassischen dreischichtigen Architektur:

- `model/`: Enthält die Datenmodelle
  - `Person.java`: Basisklasse für alle Personentypen
  - `Student.java`: Erweitert Person um studentenspezifische Attribute
  - `Lecturer.java`: Erweitert Person um dozentenspezifische Attribute

- `controller/`: folgt noch

- `app/`: Enthält Anwendungsklassen zum Testen und Demonstrieren
  - `PersonApp.java`: Demonstriert die Verwendung der Person-Klasse
  - `StudentApp.java`: Demonstriert die Verwendung der Student-Klasse
  - `LecutrerApp.java`: Demonstriert die Verwendung der Lecturer-Klasse

## Vererbung im Projekt

Vererbung ist ein fundamentales Konzept der objektorientierten Programmierung. In diesem Projekt wird Vererbung wie folgt implementiert:

1. **Basisklasse `Person`**:
   - Definiert gemeinsame Attribute (firstName, lastName, birthYear, city)
   - Implementiert gemeinsame Methoden (input(), info())

2. **Abgeleitete Klassen**:
   - `Student` erweitert `Person` mit zusätzlichen Attributen (id, subject)
   - `Lecturer` erweitert `Person` mit zusätzlichen Attributen (department)

3. **Umsetzung im Code**:
   - Verwendung des `extends`-Schlüsselworts (z.B. `public class Student extends Person`)
   - Aufruf des Konstruktors der Basisklasse mittels `super()`
   - Überschreiben von Methoden mit `@Override`
   - Nutzung von `protected`-Attributen für Zugriff in abgeleiteten Klassen

## Verwendung

Die App-Klassen demonstrieren die Verwendung des Systems. Jede App-Klasse erstellt Objekte des entsprechenden Typs, initialisiert sie mit Benutzereingaben und zeigt ihre Informationen an.