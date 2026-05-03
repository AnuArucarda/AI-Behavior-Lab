#!/bin/bash

# build-wrapper.sh
# Simple script for building the project with error checking and logging.

# Log file
LOG_FILE="build.log"

# Function to log messages
log() {
    echo "[33m[$(date +'%Y-%m-%d %H:%M:%S')] [0m$1" | tee -a "$LOG_FILE"
}

# Start logging
log "Build process started"

# Check for required tools
REQUIRED_TOOLS=(make gcc g++)
for tool in "${REQUIRED_TOOLS[@]}"; do
    if ! command -v $tool &> /dev/null; then
        log "Error: $tool is not installed." 
        exit 1
    fi
done

log "All required tools are installed."

# Run build command
log "Running build..."
make
BUILD_STATUS=$?

if [ $BUILD_STATUS -ne 0 ]; then
    log "Build failed with status: $BUILD_STATUS"
    exit $BUILD_STATUS
fi

log "Build completed successfully."

# Additional commands (tests, etc.) can be added here
log "Build process finished."