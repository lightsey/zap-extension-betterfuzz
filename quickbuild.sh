#!/bin/sh

ant -f build/build.xml -lib lib clean && ant -f build/build.xml -lib lib && cp build/zap-exts/betterfuzz-*.zap ~/bin/ZAP_2.2.2/plugin/