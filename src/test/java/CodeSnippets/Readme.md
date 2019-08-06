#CSS Selectors in Selenium


## Locating Elements by Attribute

Assume we need to identify a tag with following attributes [id, class, value, name] 

	<input type="text" id="fistname" name="first_name" class="myForm">

The syntax of locating elements by their attribute in CSS Selectors is

### css = element_name[<attribute_name>='<value>']

for above element, the CSS will be 
	input[name='first_name']

Alternatively:
  =>  # notation to select the id eg
	css="input#firstname" or just css="#firstname"
  =>  . notation to select the class	
	css="input.myForm" or just css=".myForm"

## Locating elements with More Than One Attribute

Suppose you have an HTML snippet as <div class="ajax_enabled" style="display:block">

We can specify multiple attributes as

	css="div[class='ajax_enabled'] [style='display:block']"


## Locating Child Element
eg. <div id="child"><img src="./logo.png"></div>

	css="div#child img"


There are occasions when there are multiple child elements within the same parent element such as list elements

	<ul id="fruit">
    		<li>Apple</li>
    		<li>Orange</li>
    		<li>Banana</li>
	</ul>

to locate the element with text ‘Orange’, we have to use “nth-of-type”

	css="ul#fruit li:nth-of-type(2)"

to select the last child element, i.e. ‘Banana’, we can use

	css="ul#fruit li:last-child"


## Strings and Randomly Generated Ids

### Starts with, Ends with and Contains

In this example, all the three div elements contain the word ‘random’.

  	<div id="123_randomId">
  	<div id="randomId_456">
  	<div id="123_pattern_randomId">

If we want to select the first div element, we would use ^= which means ‘starts with’:
	css="div[id^='123']"


To select the second div element, we would use $= which means ‘ends with’:
	css="div[id$='456']"

to select the last div element we would use *= which means ‘sub-string’
	css="div[id*='_pattern_']"

	We can also use the ‘contains’
		css="div:contains(_pattern_)"

### Attribute NOT contain a specific value

Suppose you have many elements which share the same attribute and attribute value, but some of those elements have other variables appended to the value. eg:

	<div class="day past calendar-day-2017-02-13 calendar-dow-1 unavailable">
	<div class="day today calendar-day-2017-02-14 calendar-dow-2 unavailable">
	<div class="day calendar-day-2017-02-15 calendar-dow-3">
	<div class="day calendar-day-2017-02-16 calendar-dow-4">

In the above snippet, we want to select an available day (i.e. the two last divs)

	css = "div[class*=calendar-day-]:not([class*='unavailable'])"
	

