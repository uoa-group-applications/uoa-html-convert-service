uoa-html-convert-service
========================

A service that converts HTML to Markdown

Contains two maven modules:

* convert-war; bundles elements and produces WAR-artifact
* convert-bus; Syllabus implementation for the markdown conversion event

## Conversion

Currently the following conversions are supported:

* headers
* horizontal rule
* line break (<br/>)
* blockquotes
* paragraphs
* images (optional alt)
* links (optional title)
* strong, em, b and i-tags for emphasis
* ordered lists
* unordered lists

## Future

What needs to be implemented:

* tables
* code blocks
* nested unordered lists 
* definition lists (hardly ever used)
