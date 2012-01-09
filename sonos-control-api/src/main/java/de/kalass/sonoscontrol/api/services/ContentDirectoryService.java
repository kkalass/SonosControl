// AUTOGENERATED: 22727e7a64e69e7f0e0051876e67577d
// AUTOGENERATED: Please feel free to enhance this sourcecode manually 
// AUTOGENERATED: (for example by adding more structure or convenience methods), and
// AUTOGENERATED: do not forget to remove this comment, especially the very first line so your changes are not overridden
package de.kalass.sonoscontrol.api.services;

import de.kalass.sonoscontrol.api.core.EventListener;
import javax.annotation.CheckForNull;

import de.kalass.sonoscontrol.api.core.Callback0;
import de.kalass.sonoscontrol.api.core.Callback1;
import de.kalass.sonoscontrol.api.model.contentdirectory.SearchCapabilities;
import de.kalass.sonoscontrol.api.model.contentdirectory.SortCapabilities;
import de.kalass.sonoscontrol.api.model.contentdirectory.SystemUpdateID;
import de.kalass.sonoscontrol.api.model.contentdirectory.AlbumArtistDisplayOption;
import de.kalass.sonoscontrol.api.model.contentdirectory.LastIndexChange;
import de.kalass.sonoscontrol.api.model.contentdirectory.BrowseResult;
import de.kalass.sonoscontrol.api.model.contentdirectory.FindPrefixResult;
import de.kalass.sonoscontrol.api.model.contentdirectory.GetAllPrefixLocationsResult;
import de.kalass.sonoscontrol.api.model.contentdirectory.CreateObjectResult;
import de.kalass.sonoscontrol.api.model.contentdirectory.ShareIndexInProgress;
import de.kalass.sonoscontrol.api.model.contentdirectory.Browseable;
import de.kalass.sonoscontrol.api.model.contentdirectory.BrowseFlag;
import de.kalass.sonoscontrol.api.model.contentdirectory.ShareIndexLastError;
import de.kalass.sonoscontrol.api.model.contentdirectory.SearchCriteria;
import de.kalass.sonoscontrol.api.model.contentdirectory.ContainerUpdateIDs;
import de.kalass.sonoscontrol.api.model.contentdirectory.RecentlyPlayedUpdateID;
import de.kalass.sonoscontrol.api.model.contentdirectory.TagValueList;
import de.kalass.sonoscontrol.api.model.contentdirectory.ObjectID;
import de.kalass.sonoscontrol.api.model.contentdirectory.UserRadioUpdateID;
import de.kalass.sonoscontrol.api.model.contentdirectory.SavedQueuesUpdateID;
import de.kalass.sonoscontrol.api.model.contentdirectory.Prefix;
import de.kalass.sonoscontrol.api.model.contentdirectory.Count;
import de.kalass.sonoscontrol.api.model.contentdirectory.Index;
import de.kalass.sonoscontrol.api.model.contentdirectory.Result;
import de.kalass.sonoscontrol.api.model.contentdirectory.SortOrder;
import de.kalass.sonoscontrol.api.model.contentdirectory.Filter;
import de.kalass.sonoscontrol.api.model.contentdirectory.ShareListRefreshState;
import de.kalass.sonoscontrol.api.model.contentdirectory.SortCriteria;
import de.kalass.sonoscontrol.api.model.contentdirectory.ShareListUpdateID;
import de.kalass.sonoscontrol.api.model.contentdirectory.UpdateID;

public interface ContentDirectoryService {


    @CheckForNull
    Browseable getLastValueForBrowseable();

    void addBrowseableListener(EventListener<Browseable> listener);

    void removeBrowseableListener(EventListener<Browseable> listener);

    @CheckForNull
    ShareIndexLastError getLastValueForShareIndexLastError();

    void addShareIndexLastErrorListener(EventListener<ShareIndexLastError> listener);

    void removeShareIndexLastErrorListener(EventListener<ShareIndexLastError> listener);

    @CheckForNull
    ContainerUpdateIDs getLastValueForContainerUpdateIDs();

    void addContainerUpdateIDsListener(EventListener<ContainerUpdateIDs> listener);

    void removeContainerUpdateIDsListener(EventListener<ContainerUpdateIDs> listener);

    @CheckForNull
    RecentlyPlayedUpdateID getLastValueForRecentlyPlayedUpdateID();

    void addRecentlyPlayedUpdateIDListener(EventListener<RecentlyPlayedUpdateID> listener);

    void removeRecentlyPlayedUpdateIDListener(EventListener<RecentlyPlayedUpdateID> listener);

    @CheckForNull
    UserRadioUpdateID getLastValueForUserRadioUpdateID();

    void addUserRadioUpdateIDListener(EventListener<UserRadioUpdateID> listener);

    void removeUserRadioUpdateIDListener(EventListener<UserRadioUpdateID> listener);

    @CheckForNull
    SavedQueuesUpdateID getLastValueForSavedQueuesUpdateID();

    void addSavedQueuesUpdateIDListener(EventListener<SavedQueuesUpdateID> listener);

    void removeSavedQueuesUpdateIDListener(EventListener<SavedQueuesUpdateID> listener);

    @CheckForNull
    SystemUpdateID getLastValueForSystemUpdateID();

    void addSystemUpdateIDListener(EventListener<SystemUpdateID> listener);

    void removeSystemUpdateIDListener(EventListener<SystemUpdateID> listener);

    @CheckForNull
    ShareIndexInProgress getLastValueForShareIndexInProgress();

    void addShareIndexInProgressListener(EventListener<ShareIndexInProgress> listener);

    void removeShareIndexInProgressListener(EventListener<ShareIndexInProgress> listener);

    @CheckForNull
    ShareListRefreshState getLastValueForShareListRefreshState();

    void addShareListRefreshStateListener(EventListener<ShareListRefreshState> listener);

    void removeShareListRefreshStateListener(EventListener<ShareListRefreshState> listener);

    @CheckForNull
    ShareListUpdateID getLastValueForShareListUpdateID();

    void addShareListUpdateIDListener(EventListener<ShareListUpdateID> listener);

    void removeShareListUpdateIDListener(EventListener<ShareListUpdateID> listener);


    <C extends Callback1<SearchCapabilities>> C retrieveSearchCapabilities(C callback);

    <C extends Callback1<SortCapabilities>> C retrieveSortCapabilities(C callback);

    <C extends Callback1<SystemUpdateID>> C retrieveSystemUpdateID(C callback);

    <C extends Callback1<AlbumArtistDisplayOption>> C retrieveAlbumArtistDisplayOption(C callback);

    <C extends Callback1<LastIndexChange>> C retrieveLastIndexChange(C callback);

    <C extends Callback1<BrowseResult>> C browse(ObjectID objectID, BrowseFlag browseFlag, Filter filter, Index startingIndex, Count requestedCount, SortCriteria sortCriteria, C callback);

    <C extends Callback1<FindPrefixResult>> C findPrefix(ObjectID objectID, Prefix prefix, C callback);

    <C extends Callback1<GetAllPrefixLocationsResult>> C retrieveAllPrefixLocations(ObjectID objectID, C callback);

    <C extends Callback1<CreateObjectResult>> C createObject(ObjectID containerID, Result elements, C callback);

    <C extends Callback0> C updateObject(ObjectID objectID, TagValueList currentTagValue, TagValueList newTagValue, C callback);

    <C extends Callback0> C destroyObject(ObjectID objectID, C callback);

    <C extends Callback0> C refreshShareList(C callback);

    <C extends Callback0> C refreshShareIndex(AlbumArtistDisplayOption albumArtistDisplayOption, C callback);

    <C extends Callback0> C requestResort(SortOrder sortOrder, C callback);

    <C extends Callback1<ShareIndexInProgress>> C retrieveShareIndexInProgress(C callback);

    <C extends Callback1<Browseable>> C retrieveBrowseable(C callback);

    <C extends Callback0> C setBrowseable(Browseable browseable, C callback);

}