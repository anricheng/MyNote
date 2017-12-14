# MyNote
It's just my private notebook 
        AndroidManifest androidManifest = new AndroidManifest(manifest, res, assets, packageName);
        List<BroadcastReceiverData> broadcastReceivers = androidManifest.getBroadcastReceivers();
        List<BroadcastReceiverData> removeReceivers = new ArrayList<>();
        for(BroadcastReceiverData receiverData: broadcastReceivers){
            removeReceivers.add(receiverData);
        }
        broadcastReceivers.removeAll(removeReceivers);
        return androidManifest;
