package com.lyhsoft.utils;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.schlichtherle.truezip.fs.FsDriver;
import de.schlichtherle.truezip.fs.FsScheme;
import de.schlichtherle.truezip.fs.archive.zip.JarDriver;
import de.schlichtherle.truezip.fs.spi.FsDriverService;
import de.schlichtherle.truezip.socket.sl.IOPoolLocator;

public class AarExtension extends FsDriverService {
    private final Map<FsScheme, FsDriver> DRIVERS;

    public AarExtension() {
        DRIVERS = newMap(new Object[][]{
                {"aar", new JarDriver(IOPoolLocator.SINGLETON)}
        });
        logger.info("Registering 'aar' as archives available for placeholder replacement.");
    }

    @Override
    public Map<FsScheme, FsDriver> get() {
        return DRIVERS;
    }

    private static final Logger logger = LoggerFactory.getLogger(AarExtension.class);
}
