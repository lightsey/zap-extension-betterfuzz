This is a reworking of OWASP's ZAP Fuzz extension.

The goal is to provide a better form fuzzer than the built
in extension while still preserving existing functionality.

Ultimately I'd like to be able to select the fuzzer from
this browser history window and have this lead into a fuzzing
screen where you can select multiple fields to fuzz, specify
some fields as auto-incrementing, and set the how many fields
to fuzz simultaneously.

Shorter term goals are to change the input file format for
fuzz strings to JSON, provide the ability to specify a
fuzz validation string separate from the fuzz injection
string, and use regular expressions for the fuzz validators.

The extension does compile, but is still very rough.