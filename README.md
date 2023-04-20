# Demo Mattilsynet

## Oppgavetekst: 
Lag en REST-tjeneste som eksponerer database skjema for produksjonsplasser (vedlagt
Dockerfile, databasescript og noen enkle docker kommandoer ) Tjenesten lager du på en plattform/verktøy du er komfortabel med (bruk gjerne IntelliJ/Visual Studio (gratis utgaver)
og spring initializr, ASP.NET web API eller lignende).
Tjenesten trenger ikke ha noen form for autentisering/sikring eller feilhåndtering, og skal
bare inneholde endepunkter for å hente ut objekter filtrert på produksjonsplassId.
Det er ønskelig at koden struktureres på en hensynsmessigmåte.

## Om applikasjonen
Tjenesten eksponerer API-gresnesnitt for å hente data en predefinert datakilde. Demoen er begrensent til å
kunne hente data basert en 'produksjonsplassId' som sendes med i responsen. 


## Bygge applikasjonen
Applikasjonen bygges med Gradle
`gradle build`

## Kjøre applikasjonen
Applikasjonen kan kjøres i IDE, fra Dockimage (ikke satt opp i demo) eller gjennom Gradle `gradle bootRun`
