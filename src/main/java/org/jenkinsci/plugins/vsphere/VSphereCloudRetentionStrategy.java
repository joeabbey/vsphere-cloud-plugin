package org.jenkinsci.plugins.vsphere;

import hudson.model.Descriptor;
import hudson.slaves.CloudRetentionStrategy;
import hudson.slaves.RetentionStrategy;

import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;
import org.kohsuke.stapler.DataBoundConstructor;

public class VSphereCloudRetentionStrategy extends CloudRetentionStrategy {

    private final int idleMinutes;

    @DataBoundConstructor
    public VSphereCloudRetentionStrategy(int idleMinutes) {
        super(idleMinutes);
        this.idleMinutes = idleMinutes;
    }

    public int getIdleMinutes() {
        return idleMinutes;
    }

    @Override
    public DescriptorImpl getDescriptor() {
        return DESCRIPTOR;
    }

    @Restricted(NoExternalUse.class)
    public static final DescriptorImpl DESCRIPTOR = new DescriptorImpl();

    public static final class DescriptorImpl extends Descriptor<RetentionStrategy<?>> {
        @Override
        public String getDisplayName() {
            return "vSphere Keep-Until-Idle Retention Strategy";
        }
    }
}
