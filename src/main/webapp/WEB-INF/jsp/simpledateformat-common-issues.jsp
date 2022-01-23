 <h2>Common Issues</h2>
 <ul>
     <li>It is important to remember that the SimpleDateFormat class
         is not thread safe. It will produce unpredictable results if
         multiple threads try to use the same instance without locking.</li>
     <li>Normally use lower case "y" for the year. Upper case "Y" is
         the <a href="https://en.wikipedia.org/wiki/ISO_week_date">week year</a>
         and will normally be the same as they year but can differ around new
         year.
     </li>
     <li>L vs M: LLLL outputs the stand alone form of the month. This
         is identical to MMMM in English but in languages such as Finnish,
         MMMM varies depending on whether a day is included while LLLL
         always outputs the month in the standard form.</li>
 </ul>