| TEST CASE ID | TEST CASE NAME                                  | DESCRIPTION                                                                                                 | PRECONDITION                                          | TEST STEPS                                                   | TEST DATA                           | EXPECTED RESULTS                                                                                                                               |
| ------------ | ----------------------------------------------- | ----------------------------------------------------------------------------------------------------------- | ----------------------------------------------------- | ------------------------------------------------------------ | ----------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------- |
|              |                                                 |                                                                                                             |                                                       |                                                              |                                     |                                                                                                                                                |
| Tc_04        |  Verify User is able to create Walk pet session |  Verify that user on the Pet page can create session for walk pets at choosen time, date ,location and pet. |                                                       | Open Pets Meet app on mobile phone                           |                                     | Home page on Peets Meet ap is opened                                                                                                           |
|              |                                                 |                                                                                                             |                                                       | Click on "Pet page" section                                  |                                     | New page "Pet page" is opened with options:<br>BackWalk pet<br>Grooming session<br>Training session<br>Lost pet<br>Adoption                    |
|              |                                                 |                                                                                                             |                                                       | Click on "Walk pet" section                                  |                                     | New page opened with options for:<br>Choose time<br>Choose date<br>Pick a location<br>Choose pets<br>Comment<br>Back<br>Send                   |
|              |                                                 |                                                                                                             |                                                       | Click and choose time for walking                            | 12:24:00<br> this day in the future | 12:24: is  visible                                                                                                                             |
|              |                                                 |                                                                                                             |                                                       | Click and choose date for walking                            | 9.7.2023                            | 9/7/2023 is visible                                                                                                                            |
|              |                                                 |                                                                                                             |                                                       | Click to select location                                     |                                     | A map appears with a window message over it and text<br> "Tap to select the disired location" and OK button                                    |
|              |                                                 |                                                                                                             |                                                       | Click on "ok"button                                          |                                     | <br>A map with the approximate location appears                                                                                                |
|              |                                                 |                                                                                                             |                                                       | Click on the map<br> and choose desired location for walking |                                     | Red pin is visible on the map on the choosen location.<br>These fields are visible:<br>Back<br>Confirmation sign in orange circle for continue |
|              |                                                 |                                                                                                             |                                                       | Click on<br>confirmation sign                                |                                     | User is back on the walk pet page with options :<br>Choose time<br>Choose date<br>Pick a location<br>Choose pets<br>Comment<br>Back<br>Send    |
|              |                                                 |                                                                                                             | The user is registered<br>and has an open pet profile | Click on pets name and choose pets                           | cupko                               | Chosen pet is marked,<br>a yellow circle appears around the picture of the pet                                                                 |
|              |                                                 |                                                                                                             |                                                       | Enter text if the field Comment                              | test                                | Text is visible on the comment field                                                                                                           |
|              |                                                 |                                                                                                             |                                                       | Click on Send button                                         |                                     | User is back to the Pet page section with a window message apeared:<br>"Uspešno poslato",OK button is visible                                  |
|              |                                                 |                                                                                                             |                                                       | Click on the "Ok" button                                     |                                     | User is on the Pet page and walk pet session is created                                                                                        |