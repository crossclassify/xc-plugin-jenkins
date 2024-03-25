package io.jenkins.plugins.crossclassify;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import javax.annotation.Nonnull;
import jenkins.model.GlobalConfigurationCategory;
import jenkins.model.SimplePageDecorator;
import net.sf.json.JSONObject;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.StaplerRequest;

@Extension
@Symbol("Smart2FA")
public class Smart2FA extends SimplePageDecorator {

    private String apiKey;
    private String siteID;

    @DataBoundSetter
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @DataBoundSetter
    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSiteID() {
        return siteID;
    }


    @NonNull
    @Override
    public GlobalConfigurationCategory getCategory() {
        return GlobalConfigurationCategory.get(GlobalConfigurationCategory.Security.class);
    }

    @Nonnull
    @Override
    public String getDisplayName() {
        return "CrossClassify Smart 2FA";
    }

    public Smart2FA() {
        super();
        load();
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        this.save();
        return true;
    }
}
