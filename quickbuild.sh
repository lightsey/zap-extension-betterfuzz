#!/bin/sh

# Change to match real install directory for plugins
ZAP_INSTALL_PLUGIN_DIR=~/bin/ZAP_2.2.2/plugin/

if [ -e $ZAP_INSTALL_PLUGIN_DIR ]; then
    ant -f build/build.xml -lib lib clean && ant -f build/build.xml -lib lib && cp build/zap-exts/betterfuzz-*.zap $ZAP_INSALL_PLUGIN_DIR
else
    echo "You must configure ZAP_INSTALL_PLUGIN_DIR correctly for quickbuild to function"
fi